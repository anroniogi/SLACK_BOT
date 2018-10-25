package ac.knu.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CommandParsingServiceTest {

    private CommandParsingService commandParsingService;

    @Before
    public void setUp() {
        commandParsingService = new CommandParsingService();
    }

    /*
    @Test
    public void bot_should_understand_list_command() {
        String command = commandParsingService.parseCommand("list");
        assertTrue(command.equalsIgnoreCase("time,add"));
    }
    */
    @Test
    public void bot_should_return_current_time_when_time_command_received() {
        String result = commandParsingService.parseCommand("test time");
        assertTrue(result.contains("Current Time is : "));
    }

    @Test
    public void 봇_명령어_list_확인_친구_없을때() {
        String result = commandParsingService.parseCommand("a list");
        assertTrue(result.contains("친구가 없습니다."));
    }

    @Test
    public void 봇_명령어_list_확인_친구_있을때() {
        commandParsingService.parseCommand("a add 김상규 26 M");
        String result = commandParsingService.parseCommand("a list");
        assertTrue(result.contains("김상규"));
    }

    @Test
    public void 봇_명령어_add_확인_정보를_다_안줬을때() {
        String result = commandParsingService.parseCommand("a add");
        assertTrue(result.contains("친구이름 나이 성별(F/M) 순으로 입력해주세요"));
    }

    @Test
    public void 봇_명령어_add_확인_나이를_문자로_입력시() {
        String result = commandParsingService.parseCommand("a add 김상규 aa M");
        assertTrue(result.contains("나이는 숫자로만 입력하세요"));
    }

    @Test
    public void 봇_명령어_add_확인_성별을_잘못_입력시() {
        String result = commandParsingService.parseCommand("a add 김상규 26 Q");
        assertTrue(result.contains("성별은 F 혹은 M으로 입력해주세요"));
    }

    @Test
    public void 봇_명령어_add_확인_이름이_중복일경우() {
        commandParsingService.parseCommand("a add 김상규 26 M");
        String result = commandParsingService.parseCommand("a add 김상규 26 M");
        assertTrue(result.contains("이미 존재하는 이름입니다."));
    }

    @Test
    public void 봇_명령어_add_확인_친구가_10명_이상일때() {
        for(int i=0; i<10; i++) {
            String command = "a add " + i + " 26 M";
            commandParsingService.parseCommand(command);
        }
        String result = commandParsingService.parseCommand("a add 김상규 26 M");
        assertTrue(result.contains("10명 이상은 추가할 수 없습니다."));
    }

    @Test
    public void 봇_명령어_add_성공시() {
        String result = commandParsingService.parseCommand("a add 김상규 26 M");
        assertTrue(result.contains("친구추가 성공"));
    }

    @Test
    public void 봇_명령어_remove_확인_이름을_안썼을때() {
        String result = commandParsingService.parseCommand("a remove");
        assertTrue(result.contains("정보를 다시 입력해 주세요"));
    }

    @Test
    public void 봇_명령어_remove_확인_친구가_없을때() {
        String result = commandParsingService.parseCommand("a remove 김상규");
        assertTrue(result.contains("친구가 없습니다."));
    }

    @Test
    public void 봇_명령어_remove_확인_친구삭제_성공시() {
        commandParsingService.parseCommand("a add 김상규 26 M");
        String result = commandParsingService.parseCommand("test remove 김상규");
        assertTrue(result.contains("김상규님을 삭제했습니다."));
    }

    @Test
    public void 봇_명령어_remove_확인_삭제하려는_이름이_없을시() {
        commandParsingService.parseCommand("a add 김상규 26 M");
        String result = commandParsingService.parseCommand("test remove 이원준");
        assertTrue(result.contains("이름을 확인해주세요"));
    }

    @Test
    public void 봇_명령어_find_이름을_안썼을때() {
        String result = commandParsingService.parseCommand("test find");
        assertTrue(result.contains("정보를 다시 입력해 주세요"));
    }

    @Test
    public void 봇_명령어_find_친구_없을때() {
        String result = commandParsingService.parseCommand("test find 김상규");
        assertTrue(result.contains("친구가 없습니다."));
    }

    @Test
    public void 봇_명령어_find_성공시() {
        commandParsingService.parseCommand("a add 김상규 26 M");
        String result = commandParsingService.parseCommand("test find 김상규");
        assertTrue(result.contains("이름: 김상규 나이 : 26 성별 : M"));
    }
}


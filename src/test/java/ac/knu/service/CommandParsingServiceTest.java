package ac.knu.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CommandParsingServiceTest {

    private CommandParsingService commandParsingService;

    @Before
    public void setUp(){
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
    public void bot_should_return_current_time_when_time_command_received(){
        String result = commandParsingService.parseCommand("test time");
        assertTrue(result.contains("Current Time is : "));
    }

    @Test
    public void 봇_명령어_list_확인(){
        String result = commandParsingService.parseCommand("test list");
        assertTrue(result.contains("친구 목록"));
    }

    @Test
    public void 봇_명령어_add_확인(){
        String result = commandParsingService.parseCommand("test add");
        assertTrue(result.contains("친구 추가"));
    }

    @Test
    public void 봇_명령어_remove_확인(){
        String result = commandParsingService.parseCommand("test remove");
        assertTrue(result.contains("친구 삭제"));
    }

    @Test
    public void 봇_명령어_find_확인(){
        String result = commandParsingService.parseCommand("test find");
        assertTrue(result.contains("친구 찾기"));
    }

}

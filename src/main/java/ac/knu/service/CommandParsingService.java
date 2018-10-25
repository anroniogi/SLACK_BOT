package ac.knu.service;

import ac.knu.Friend;
import ac.knu.service.SlackBotService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class CommandParsingService {

    private List<String> commandList = new ArrayList<>();


    public CommandParsingService(){
        commandList.add("time");
        commandList.add("list");
        commandList.add("add");
        commandList.add("remove");
        commandList.add("find");
    }

    public String parseCommand(String command) {

        String[] commandSplitList = command.split(" ");
        command = commandSplitList[1];

        switch (command){
            case "time" :
                return "Current Time is : " + new Date();

            case "list" :

                //return "친구 목록 : ";

            case "add" :

                return "친구 추가";

            case "remove" :
                return "친구 삭제";

            case "find" :
                return "친구 찾기";

        }



        return "명령어 1.time  2.list  3.add  4.remove  5.find";
    }
}

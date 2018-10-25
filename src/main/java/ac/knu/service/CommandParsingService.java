package ac.knu.service;

import ac.knu.Friend;
import ac.knu.service.SlackBotService;
import org.springframework.stereotype.Service;

import java.util.*;

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
        //command = commandSplitList[1];

        switch (commandSplitList[1]){
            case "time" :
                return "Current Time is : " + new Date();

            case "list" :
                return Friend.FriendList();
                //return "친구 목록 : ";

            case "add" :
                return Friend.addFriend(command);

            case "remove" :
                return Friend.removeFriend(command);

            case "find" :
                return Friend.findFriend(command);

        }

        return "명령어 1.time  2.list  3.add  4.remove  5.find";
    }
}

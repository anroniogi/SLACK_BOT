package ac.knu;

import java.util.Vector;

import static ch.qos.logback.core.joran.action.ActionConst.NULL;

enum Gender {F, M, N};

public class Friend {
    String name = NULL;
    int age = -1;
    Gender gender = Gender.N;

    /*
    public Friend(String name, int age, Gender gender){

    }
    */

    public static Vector<Friend> friends = new Vector();

    public static String addFriend(String command){
        String[] commandSplitList = command.split(" ");
        if(commandSplitList.length != 5){
            return "친구이름 나이 성별(F/M) 순으로 입력해주세요";
        }
        if(friends.size()>=10){
            return "10명 이상은 추가할 수 없습니다.";
        }

        Friend friend = new Friend();
        for(int i=0; i<friends.size(); i++){
            if(friends.elementAt(i).name.equals(commandSplitList[2])){
                return "이미 존재하는 이름입니다.";
            }
        }
        friend.name = commandSplitList[2];
        try {
            friend.age = Integer.parseInt(commandSplitList[3]);
        }
        catch(Exception e){
            return "나이는 숫자로만 입력하세요";
        }
        switch (commandSplitList[4]){
            case "F" :
                friend.gender = Gender.F;
                break;

            case "M" :
                friend.gender = Gender.M;
                break;

            default :
                return "성별은 F 혹은 M으로 입력해주세요";
        }

        if(friend.name != "" && friend.age != -1 && friends.size() < 10) {
            friends.add(friend);
            return "친구추가 성공";
        } else {
            return "add 친구이름 나이 성별(F/M) 순으로 입력해주세요";
        }

    }

    public static String findFriend(String command){
        String[] commandSplitList = command.split(" ");
        if(commandSplitList.length != 3){
            return "정보를 다시 입력해 주세요";
        }
        if(friends.size() == 0){
            return "친구가 없습니다.";
        }
        String result = "";
        for(int i=0; i<friends.size(); i++){
            if(friends.elementAt(i).name.equals(commandSplitList[2])){
                result = "이름: " + friends.elementAt(i).name
                        + " 나이 : " + Integer.toString(friends.elementAt(i).age)
                        + " 성별 : " + friends.elementAt(i).gender;
            } else {
                result =  "찾는 친구가 없습니다.";
            }
        }
        return result;
    }

    public static String removeFriend(String command){
        String[] commandSplitList = command.split(" ");
        if(commandSplitList.length != 3){
            return "정보를 다시 입력해 주세요";
        }
        if(friends.size() == 0){
            return "친구가 없습니다.";
        }
        for(int i=0; i<friends.size(); i++) {
            if (friends.elementAt(i).name.equals(commandSplitList[2])) {
                String result = friends.elementAt(i).name + "님을 삭제했습니다.";
                friends.remove(i);
                return result;
            }
        }
        return "이름을 확인해주세요";
    }

    public static String FriendList(){
        String friendList = "";
        if(friends.size() == 0){
            return "친구가 없습니다.";
        }
        for(int i=0; i<friends.size(); i++){
            String name = friends.elementAt(i).name;
            friendList += name + "";
        }
        return friendList;
    }



}

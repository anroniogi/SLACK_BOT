package ac.knu;

import java.util.Vector;

import static ch.qos.logback.core.joran.action.ActionConst.NULL;

enum Gender {F, M};

public class Friend {
    String name = NULL;
    int age = -1;
    Gender gender;

    /*
    public Friend(String name, int age, Gender gender){

    }
    */

    public Vector<Friend> friends = new Vector();

    public Vector<Friend> getFriends() {
        return friends;
    }

    public void addFriend(String name, int age, Gender gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void findFriend(){

    }

    public void removeFriend(){

    }

    public void FriendList(){

    }



}

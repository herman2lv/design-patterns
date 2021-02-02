package com.epam.rd.autocode.observer.git;

public class GitRepoObservers {
    public static Repository newRepository(){
        return new SimpleRepository();
    }

    public static WebHook mergeToBranchWebHook(String branchName){
        return new SimpleWebHook(Event.Type.MERGE, branchName);
    }

    public static WebHook commitToBranchWebHook(String branchName){
        return new SimpleWebHook(Event.Type.COMMIT, branchName);
    }


}

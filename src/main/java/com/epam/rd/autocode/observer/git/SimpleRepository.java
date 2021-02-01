package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleRepository implements Repository {
    private final List<WebHook> webHooks = new ArrayList<>();
    private final List<Event> events = new ArrayList<>();

    @Override
    public void addWebHook(WebHook webHook) {
        webHooks.add(webHook);
    }

    @Override
    public Commit commit(String branch, String author, String[] changes) {
        Commit commit = new Commit(author, changes);
        Event event = new Event(Event.Type.COMMIT, branch, Collections.singletonList(commit));
        events.add(event);
        for (WebHook webHook : webHooks) {
            webHook.onEvent(event);
        }
        return commit;
    }

    @Override
    public void merge(String sourceBranch, String targetBranch) {
        List<Commit> commitsOnTargetBranch = getCommitsFromBranch(targetBranch);
        List<Commit> commitsOnSourceBranch = getCommitsFromBranch(sourceBranch);
        commitsOnSourceBranch.removeAll(commitsOnTargetBranch);
        if (commitsOnSourceBranch.isEmpty()) {
            return;
        }
        Event event = new Event(Event.Type.MERGE, targetBranch, commitsOnSourceBranch);
        events.add(event);
        for (WebHook webHook : webHooks) {
            webHook.onEvent(event);
        }
    }

    private List<Commit> getCommitsFromBranch(String branch) {
        return events.stream()
                .filter(e -> e.branch().equalsIgnoreCase(branch))
                .map(Event::commits)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }
}

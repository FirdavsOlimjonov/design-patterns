package com.epam.rd.autocode.observer.git;

import java.util.*;

public class RepositoryImpl implements Repository {

    private List<WebHook> webHooks = new ArrayList<>();

    @Override
    public void addWebHook(WebHook webHook) {
        webHooks.add(webHook);
    }

    @Override
    public Commit commit(String branch, String author, String[] changes) {

        Commit commit = new Commit(author, changes);
        for (WebHook webHook : webHooks) {
            if (webHook.branch().equals(branch)&& Objects.equals(webHook.type(), Event.Type.COMMIT)) {
                Event event = new Event(webHook.type(), branch, List.of(commit));
                webHook.onEvent(event);
            }
        }
        return commit;
    }

    @Override
    public void merge(String sourceBranch, String targetBranch) {
        WebHook source = null;
        WebHook target = null;
        for (WebHook webHook : webHooks) {
            if (webHook.branch().equals(sourceBranch)&& Objects.equals(webHook.type(), Event.Type.COMMIT))
                source = webHook;

            if (webHook.branch().equals(targetBranch) && Objects.equals(webHook.type(), Event.Type.MERGE))
                target = webHook;
        }

        if (source == null || target == null)
            return;

        List<Commit> list = new ArrayList<>();

        for (Event caughtEvent : source.caughtEvents()) {
            List<Commit> commits = caughtEvent.commits();
            list.addAll(commits);
        }

        Event event = new Event(Event.Type.MERGE, targetBranch, list);

        if (target.caughtEvents().size() > 0)
            if (event.toString().equals(target.caughtEvents().get(0).toString()))
                return;

        target.onEvent(event);
    }

}

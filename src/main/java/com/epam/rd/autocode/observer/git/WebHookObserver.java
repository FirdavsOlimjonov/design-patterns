package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class WebHookObserver implements WebHook {

    String branch;

    Event.Type type;

    List<Event> caughtEvents = new ArrayList<>();

    public WebHookObserver(String branch, Event.Type type) {
        this.branch = branch;
        this.type = type;
    }

    @Override
    public String branch() {
        return branch;
    }

    @Override
    public Event.Type type() {
        return type;
    }

    @Override
    public List<Event> caughtEvents() {
        return caughtEvents;
    }

    @Override
    public void onEvent(Event event) {
        caughtEvents.add(event);
    }

//    @Override
//    public String toString() {
//        if (type.equals(Event.Type.MERGE)) {
//             new StringJoiner(", ", Event.class.getSimpleName() + "[", "]")
//                    .add(branch)
//                    .add(.toString())
//                .toString();
//
//        }
//    }
}

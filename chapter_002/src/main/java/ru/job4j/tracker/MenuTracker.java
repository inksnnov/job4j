package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class MenuTracker {

    private Input input;

    private Tracker tracker;

    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int getActionLenght() {
        return this.actions.size();
    }

    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new ReplaceItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new ShowAllItem());
        this.actions.add(new FindByNameItems());
        this.actions.add(new FindByIdItem());
        this.actions.add(new ExitProgram());
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}

package com.github.knowledge.desigerPattern.command.classCommand;

/**
 * @author: zhangrx
 * @date: 2016/3/23 23:28
 */
public class ConcreteCommand implements Command {

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {

    }

    /**
     * @directed
     * @clientRole receiver
     */
    private Receiver receiver;
}

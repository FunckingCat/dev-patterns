package org.example.impl;

import org.example.behavior.Linker;

import java.util.ArrayList;
import java.util.List;

public class MegaMenu implements Linker<MenuItem> {

    private final List<Linker<MenuItem>> items = new ArrayList<>();

    public void add(Linker<MenuItem> linker) {
        items.add(linker);
    }

    @Override
    public List<MenuItem> getAll() {
        return items.stream().map(Linker::getAll)
                .flatMap(List::stream)
                .peek(item -> item.setMenuName(this.getClass().getSimpleName() + "->" + item.getMenuName()))
                .toList();
    }

}

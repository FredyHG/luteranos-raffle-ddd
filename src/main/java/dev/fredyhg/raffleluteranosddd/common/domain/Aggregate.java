package dev.fredyhg.raffleluteranosddd.common.domain;

import lombok.Getter;

@Getter
public abstract class Aggregate<ID extends Identifier> {
    private final ID id;

    protected Aggregate(ID id) {
        this.id = id;
    }
}

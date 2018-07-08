package com.my.backery.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.io.Serializable;

@AllArgsConstructor
@Builder
public class QueueItem implements Serializable {

    private static final long serialVersionUID = -2114537791931683701L;

    private MenuItem menuItem;
    private Order order;
}

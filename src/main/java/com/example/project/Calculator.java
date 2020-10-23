/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

public class Calculator {
    public String firstName;
    public String lastName;

    public int add(int a, int b) {
        return a + b;
    }

    public Double multiply(Double a, Double b) {
        return a * b;
    }

    public Integer multiply(Integer a, Integer b) {
        return a * b;
    }

    public Double divide(double a, int b) {
        return a / b;
    }

}

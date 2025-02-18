/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2023. Ivanchuck Ivan.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package ru.l3r8y.parser;

import java.nio.file.Path;
import lombok.AllArgsConstructor;
import ru.l3r8y.Method;

/**
 * It's a simple data class that holds the parsed method's name, class name, body,
 * and path.
 *
 * @since 0.1.0
 */
@AllArgsConstructor
@SuppressWarnings("PMD.AvoidFieldNameMatchingMethodName")
public final class ParsedMethod implements Method {

    /**
     * The class owner.
     */
    private final String owner;

    /**
     * Method name.
     */
    private final String name;

    /**
     * Method body.
     */
    private final String body;

    /**
     * Path to '.java' file.
     */
    private final Path path;

    @Override
    public String className() {
        return this.owner;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String body() {
        return this.body;
    }

    @Override
    public Path path() {
        return this.path;
    }
}

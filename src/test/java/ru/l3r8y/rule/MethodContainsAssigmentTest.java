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
/*
 * @todo #1 Write implementation to pass #failsWithoutThisKeyword test case
 * Assigment must fails not only with 'this.' construction.
 */
package ru.l3r8y.rule;

import java.nio.file.Path;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.l3r8y.extensions.CaseWithoutThis;
import ru.l3r8y.extensions.InvalidClass;
import ru.l3r8y.extensions.ValidClass;

/**
 * Test case for {@link MethodContainsAssigment}.
 *
 * @since 0.1.0
 */
final class MethodContainsAssigmentTest {

    @Test
    @ExtendWith(InvalidClass.class)
    void failsWhenInvalid(final Path clazz) {
        MatcherAssert.assertThat(
            new CompositePathRule(clazz).complaints().size(),
            Matchers.equalTo(1)
        );
    }

    @Test
    @ExtendWith(CaseWithoutThis.class)
    @Disabled
    void failsWithoutThisKeyword(final Path clazz) {
        MatcherAssert.assertThat(
            new CompositePathRule(clazz).complaints().size(),
            Matchers.equalTo(1)
        );
    }

    @Test
    @ExtendWith(ValidClass.class)
    void passesWhenValid(final Path clazz) {
        MatcherAssert.assertThat(
            new CompositePathRule(clazz).complaints(),
            Matchers.empty()
        );
    }
}

package com.github.wenhao;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest
{
    @Test
    public void should_run_junit_test() {
        // given
        App app = new App();

        // when
        boolean result = app.runTest();

        // then
        assertThat(result).isEqualTo(true);
    }
}

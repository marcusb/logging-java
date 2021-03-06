/*
 * Copyright (c) 2012-2014 Spotify AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.spotify.logging;

import org.junit.Test;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.net.SyslogAppender;

import static com.spotify.logging.LoggingConfigurator.getSyslogAppender;
import static org.junit.Assert.assertEquals;

public class LoggingConfiguratorTest {

  @Test
  public void testGetSyslogAppender() {
    final LoggerContext context = new LoggerContext();

    SyslogAppender appender = (SyslogAppender) getSyslogAppender(context, "", -1);
    assertEquals("wrong host", "localhost", appender.getSyslogHost());
    assertEquals("wrong port", 514, appender.getPort());

    appender = (SyslogAppender) getSyslogAppender(context, null, -1);
    assertEquals("wrong host", "localhost", appender.getSyslogHost());
    assertEquals("wrong port", 514, appender.getPort());

    appender = (SyslogAppender) getSyslogAppender(context, "host", -1);
    assertEquals("wrong host", "host", appender.getSyslogHost());
    assertEquals("wrong port", 514, appender.getPort());

    appender = (SyslogAppender) getSyslogAppender(context, null, 999);
    assertEquals("wrong host", "localhost", appender.getSyslogHost());
    assertEquals("wrong port", 999, appender.getPort());

  }

}

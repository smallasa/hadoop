/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.yarn.service.provider.defaultImpl;

import org.apache.hadoop.yarn.service.provider.AbstractClientProvider;
import org.apache.hadoop.yarn.service.provider.ProviderService;
import org.apache.hadoop.yarn.service.provider.ProviderFactory;

public final class DefaultProviderFactory extends ProviderFactory {
  private static final ProviderFactory FACTORY = new
      DefaultProviderFactory();

  private DefaultProviderFactory() {}

  private static class Client {
    static final AbstractClientProvider PROVIDER = new DefaultClientProvider();
  }

  private static class Server {
    static final ProviderService PROVIDER = new DefaultProviderService();
  }

  @Override
  public AbstractClientProvider createClientProvider() {
    return Client.PROVIDER;
  }

  @Override
  public ProviderService createServerProvider() {
    return Server.PROVIDER;
  }

  public static ProviderFactory getInstance() {
    return FACTORY;
  }
}

<img src="https://www.openhwgroup.org/images/openhw-landscape.svg" width="418px" height="103px" /> <img src="https://www.openhwgroup.org/images/core-v-portrait.png" align="right" width="150px" height="120px"/>

## OpenHW Group CORE-V IDE based on Eclipse CDT

[![Eclipse License](https://img.shields.io/badge/license-EPL--2.0-brightgreen.svg)](https://github.com/openhwgroup/core-v-ide-cdt/blob/master/LICENSE)
[![Build Status](https://github.com/openhwgroup/core-v-ide-cdt/workflows/CI/badge.svg)](https://github.com/openhwgroup/core-v-ide-cdt/actions)

### License

Copyright (c) 2020, 2022 OpenHW Group and others.

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
[https://www.eclipse.org/legal/epl-2.0/](https://www.eclipse.org/legal/epl-2.0/).

SPDX-License-Identifier: EPL-2.0

### Building

#### Prerequisites:
 1. Java (JDK) 11+
 2. Apache Maven 3.6.3
 3. Internet access

#### Build
```sh
git clone https://github.com/openhwgroup/core-v-ide-cdt.git
cd core-v-ide-cdt
mvn verify
```
Produced p2 repository can be found at `releng/org.openhwgroup.corev.ide.repository/target`

Produced runnable products can be found at `products/org.openhwgroup.corev.ide.product/target/products/org.openhwgroup.corev.ide.product`

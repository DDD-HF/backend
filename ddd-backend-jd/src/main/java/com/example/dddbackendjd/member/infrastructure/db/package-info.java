@ApplicationModule(
        displayName = "db",
        allowedDependencies = {"member.domain :: spi", "member.domain.model"}
)
package com.example.dddbackendjd.member.infrastructure.db;

import org.springframework.modulith.ApplicationModule;
@ApplicationModule(
        displayName = "mapper",
        allowedDependencies = {"common :: configuration", "member.domain.api.dto", "member.presentation.dto"}
)
package com.example.dddbackendjd.member.application.mapper;

import org.springframework.modulith.ApplicationModule;
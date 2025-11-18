package com.example.dddbackend.common.configuration;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {EnumConverter.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface MapStructConfig {
}

package com.example.demo;

import java.util.Collections;

import com.example.demo.Sb38941Application.Sb38941ApplicationRuntimeHints;
import liquibase.changelog.ChangeLogHistoryServiceFactory;

import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints(Sb38941ApplicationRuntimeHints.class)
public class Sb38941Application {

	public static void main(String[] args) {
		SpringApplication.run(Sb38941Application.class, args);
	}

	static class Sb38941ApplicationRuntimeHints implements RuntimeHintsRegistrar {

		@Override
		public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
			hints.reflection().registerType(ChangeLogHistoryServiceFactory.class, (type) ->
					type.withConstructor(Collections.emptyList(), ExecutableMode.INVOKE));
		}
	}

}

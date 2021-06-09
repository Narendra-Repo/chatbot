package com.example.application;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.alicebot.ab.Bot;
import org.alicebot.ab.configuration.BotConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.vaadin.artur.helpers.LaunchUtil;
import com.vaadin.flow.theme.Theme;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@Theme(value = "chatbot")
@PWA(name = "Chat bot", shortName = "Chat bot", offlineResources = { "images/logo.png" })
public class Application extends SpringBootServletInitializer implements AppShellConfigurator {

	public static void main(String[] args) {
		LaunchUtil.launchBrowserInDevelopmentMode(SpringApplication.run(Application.class, args));
	}

	@Bean
	public Bot alice() {

		return new Bot(BotConfiguration.builder()

				.name("alice")

				.path("src/main/resources")

				.build()

		);

	}

	@Bean
	public ScheduledExecutorService executorService() {

		return Executors.newScheduledThreadPool(2);

	}
}

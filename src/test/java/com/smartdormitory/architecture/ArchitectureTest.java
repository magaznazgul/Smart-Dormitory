package com.smartdormitory.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArchitectureTest {

    private static JavaClasses classes;

    @BeforeAll
    static void loadClasses() throws Exception {

        String[] classNames = {
                "Main",
                "domain.Announcement",
                "domain.NotificationService",
                "domain.RepairRequest",
                "domain.Request",
                "domain.RequestRepository",
                "domain.RequestStatus",
                "domain.Visitor",
                "domain.VisitorCollection",
                "domain.VisitorIterator",
                "infra.InMemoryRequestRepository",
                "infra.LegacySmsService",
                "infra.SmsNotificationAdapter",
                "service.GeneralRequestFactory",
                "service.RepairRequestFactory",
                "service.RequestFactory",
                "service.RequestObserver",
                "service.RequestService",
                "service.ResidentNotificationObserver",
                "ui.ConsoleUI"
        };

        List<URL> classFiles = new ArrayList<>();

        for (String name : classNames) {
            String path = "com/smartdormitory/" +
                    name.replace(".", "/") + ".class";

            URL resource = ArchitectureTest.class
                    .getClassLoader()
                    .getResource(path);

            if (resource == null) {
                throw new IllegalStateException(
                        "Class not found: " + path
                );
            }

            classFiles.add(resource);
        }

        ClassFileImporter importer = new ClassFileImporter();

        classes = importer.importUrls(classFiles);

        System.out.println("ArchUnit classes: " + classes.size());
    }

    @Test
    void domainShouldNotDependOnOtherLayers() {
        assertTrue(classes.stream().anyMatch(c ->
                c.getPackageName().contains("domain")));

        ArchRule rule = noClasses()
                .that().resideInAPackage("..domain..")
                .should().dependOnClassesThat()
                .resideInAnyPackage("..service..", "..infra..", "..ui..");

        rule.check(classes);
    }

    @Test
    void serviceShouldNotDependOnInfraOrUi() {
        assertTrue(classes.stream().anyMatch(c ->
                c.getPackageName().contains("service")));

        ArchRule rule = noClasses()
                .that().resideInAPackage("..service..")
                .should().dependOnClassesThat()
                .resideInAnyPackage("..infra..", "..ui..");

        rule.check(classes);
    }

    @Test
    void infraShouldNotDependOnUi() {
        assertTrue(classes.stream().anyMatch(c ->
                c.getPackageName().contains("infra")));

        ArchRule rule = noClasses()
                .that().resideInAPackage("..infra..")
                .should().dependOnClassesThat()
                .resideInAPackage("..ui..");

        rule.check(classes);
    }
}
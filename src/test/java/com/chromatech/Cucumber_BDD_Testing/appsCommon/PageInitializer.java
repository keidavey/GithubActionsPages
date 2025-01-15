package com.chromatech.Cucumber_BDD_Testing.appsCommon;

import com.chromatech.Cucumber_BDD_Testing.pages.*;

public class PageInitializer {

    /**
     * THIS PAGE WILL BE USED TO INITIALIZE ALL
     * PAGE OBJECTS
     */

    public static StudentAdmissionPage studentAdmissionPage;
    public static DashboardPage dashboardPage;
    public static StudentDetailsPage studentDetailsPage;
    public static StudentEditPage studentEditPage;
    public static BulkDeletePage bulkDeletePage;
    public static AddAndDeleteSectionsPage addAndDeleteSectionsPage;
    public static ClassesPage classesPage;
    public static CategoryPage categoryPage;
    public static DisabledStudentPage disabledStudentPage;

    public static void initializeAllPages() {
        studentAdmissionPage = new StudentAdmissionPage();
        dashboardPage = new DashboardPage();
        studentDetailsPage = new StudentDetailsPage();
        studentEditPage = new StudentEditPage();
        bulkDeletePage = new BulkDeletePage();
        addAndDeleteSectionsPage = new AddAndDeleteSectionsPage();
        classesPage = new ClassesPage();
        categoryPage = new CategoryPage();
        disabledStudentPage = new DisabledStudentPage();
    }
}
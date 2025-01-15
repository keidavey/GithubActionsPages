package com.cicd.Cucumber_BDD_Testing.appsCommon;

import com.cicd.Cucumber_BDD_Testing.pages.GooglePage;
import com.chromatech.Cucumber_BDD_Testing.pages.*;

public class PageInitializer {

    /**
     * THIS PAGE WILL BE USED TO INITIALIZE ALL
     * PAGE OBJECTS
     */

    public static GooglePage googlePage;

    public static void initializeAllPages() {
        googlePage = new GooglePage();
    }
}
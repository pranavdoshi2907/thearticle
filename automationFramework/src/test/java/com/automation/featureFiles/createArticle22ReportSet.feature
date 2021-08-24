#Author: shivangi.tripathi@zensar.com (Quality Analyst)
@ILONormes
Feature: ILO Normes Application Functionality- Create Article 22 report set

  @ILONormes @CreateArticle22ReportSet @ChancellerySupervisor @CS&HoU
  Scenario Outline: User creates new report set in the ILO Normes application as a Chancellery Supervisor
    Given user logged in to the SharePoint application
    And user deletes the Created Report set
    Given user switched to "Chancellery Supervisor" view
    When user clicks on "Add new report set" icon
    And user selects "Article Type" dropdown
    And user selects dropdowns for "<new_report_set>"
    And user clicks on "Save Report Set" icon
    And user clicks on "yes" icon
    And report metadata is displayed successfully for the created report set
    And user selects "Select Chancellery Member" dropdown
    And user clicks on "chancelleryMemberName1" icon
    And user clicks on "yes button for C138" icon
    And user selects the Current Reception Date for the C138 report received
    And user clicks on "yes button for C182" icon
    And user selects the Current Reception Date for the C182 report received
    And user clicks on "saveBtnForC138" icon
    And user clicks on "Add file(s) below-Report Registration" icon
    And user selects Select Annex Type, Select Convention(s), Select Language, Choose File, Language to be translated on the Add government reports and annexes page
    And user clicks on "Save file(s) in workflow" icon
    And user clicks on "notifyHoUAboutNewReportsOrAnnexesUploads" icon
    And the HoU is notified about new reports or annexes uploads "<HoU_Notification_Msge>"
    And user clicks on "ReprtTranslationIconOnChancellerySupervisorPage" icon
    And user clicks on "upload" icon
    And user uploads the file for RELMEETINGS
    And user clicks on "Add File" icon
    And user clicks on "OK" icon
    And user clicks on "checkBoxForFileTranslation" icon
    And user clicks on "Send above selected docs for translation" icon
    And user clicks on "OK" icon
    Then the user gets the "<report_translation_message>"
    And user clicks on "Close report set" icon
    And user clicks on "OK" icon

    Examples: 
      | new_report_set            | HoU_Notification_Msge             | report_translation_message                          |
      | Article 22 new report set | Notified by: ILO_SHAREPOINT_TEST1 | Batch for translation sent by: ILO_SHAREPOINT_TEST1 |

  @ILONormes @CreateArticle22ReportSet @HeadOfUnit @CS&HoU
  Scenario: User is logged in as Head of Unit and performs the role of Head of Unit
    Given user switched to "Head of Unit" view
    And user enters the report set name in the report set name column
    And user clicks on "createReportSetBtnLink" icon
    And user clicks on "ReportValidationIconOnHeadOfUnitPage" icon
    And user clicks on "Observation Checkbox Of First Row" icon
    And user clicks on "Cancel" icon
    And user clicks on "LegalSpecialistAssignment" icon
    And user selects "assignThematicLeadAndLegalSpecialistOption" dropdown
    And user clicks on "assignLegalSpecialistCheckBox" icon
    And user assigns the "Legal_Specialist_Role"
    And user clicks on "assignThematicLeadCheckBox" icon
    And user assigns the "Thematic_Lead_Role"
    And user clicks on "save" icon
    And user clicks on "Close report set" icon

  @ILONormes @CreateArticle22ReportSet @ThematicLead
  Scenario: User is logged in as Thematic Lead and performs the role of Thematic Lead
    Given user switched to "Thematic Lead" view
    And user enters the report set name in the report set name column
    And user clicks on "createReportSetBtnLink" icon
    And user clicks on "Thematic Lead sign-off" icon
    And user clicks on "Yes" icon
    And user clicks on "Close report set" icon
    And user clicks on "OK" icon

  @ILONormes @CreateArticle22ReportSet @LegalSpecialist
  Scenario: User is logged in as Legal Specialist and performs the role of Legal Specialist
    Given user switched to "Legal Specialist" view
    And user enters the report set name in the report set name column
    And user clicks on "createReportSetBtnLink" icon
    And user deleted the existing added file
    And user clicks on "Add Files Below" icon
    And selects Document Type, Convention Type, Language of the Document, File to be uploaded on the add research background documents' page
    And user clicks on "Save Files In WorkFlow" icon
    And user selects comment needed or not for "convention_138"
    And user selects comment needed or not for "convention_182"
    And user clicks on "save" icon
    And user clicks on "create_DLC" icon
    And user creates "newDLCForC138"
    And user clicks on "create_DLC" icon
    And user creates "newDLCForC182"
    And user clicks on "technicalDepartmentInputsTab" icon
    And user clicks on "inputNeededYes" icon
    And user clicks on "save" icon
    And user selects "selectTechDepPersonDropDown" dropdown
    And user selects "techDepAssignedUsername" dropdown
    And user clicks on "Assign" icon

  @ILONormes @CreateArticle22ReportSet @TechDepartmentUser
  Scenario: User logged in as Technical Department User and performs the role of Technical Department User
    Given user switched to "Technical Department User" view
    And user enters the report set name in the report set name column
    And user clicks on "createReportSetBtnLink" icon
    And user clicks on "Endtask" icon
    And user fills the "techInputCompletion" box
    And user clicks on "ProceedBtn" icon

  @ILONormes @CreateArticle22ReportSet @LegalSpecDraftDLCView
  Scenario: User is logged in as Legal Specialist and performs the role of Legal Specialist on the Draft DLC tab
    Given user switched to "Legal Specialist" view
    And user enters the report set name in the report set name column
    And user clicks on "createReportSetBtnLink" icon
    And user clicks on "draftDLCTab" icon
    And user clicks on "yesOptionForCaseSensitiveApprovalOfCoB" icon
    And user clicks on "save" icon
    And user clicks on "readyForThematicLeadSignOffIcon" icon
    And user clicks on "Close report set" icon

  #And user clicks on "OK" icon
  @ILONormes @CreateArticle22ReportSet @ThematicLeadSignOff
  Scenario: User is logged in as Thematic Lead and signs off as Thematic Lead
    Given user switched to "Thematic Lead" view
    And user enters the report set name in the report set name column
    And user clicks on "createReportSetBtnLink" icon
    And user clicks on "readyForThematicLeadSignOffIcon" icon
    And user clicks on "yesBtnForApproval" icon

  @ILONormes @CreateArticle22ReportSet @HeadOfUnitSignOff
  Scenario: User is logged in as Head of Unit and signs off as Head of Unit
    Given user switched to "Head of Unit" view
    And user enters the report set name in the report set name column
    And user clicks on "createReportSetBtnLink" icon
    And user clicks on "initialHoUSignOff" icon

  @ILONormes @CreateArticle22ReportSet @ChiefOfBranchSignOff
  Scenario: User is logged in as Chief of Branch and signs off as Chief of Branch
    Given user switched to "Chief of Branch" view
    And user enters the report set name in the report set name column
    And user clicks on "createReportSetBtnLink" icon
    And user clicks on "chiefOfBranchSignOff" icon
    
    @ILONormes @CreateArticle22ReportSet @Step2ExpertReviewHoULogin
    Scenario: User is logged as Head of Unit and gives the Yes review 
    Given user switched to "Head of Unit" view
    And user enters the report set name in the report set name column
    And user clicks on "createReportSetBtnLink" icon
    And user clicks on "yesReviewForCEACRExpert" icon
    And user clicks on "save" icon 
    
    @ILONormes @CreateArticle22ReportSet @Step2ExpertReviewExpertReview1Login @Step2ExpertReviewLogin
    Scenario: User is logged in as Expert Review 1 task in the step 2 flow
    Given user switched to "Expert Review 1" view
    And user enters the report set name in the report set name column
    And user clicks on "createReportSetBtnLink" icon
    And user clicks on "endTask" icon
    And user clicks on "expertReviewCompletionSelection" icon
    And user clicks on "ProceedBtn" icon
    
    @ILONormes @CreateArticle22ReportSet @Step2ExpertReviewExpertReview2Login @Step2ExpertReviewLogin
    Scenario: User is logged in as Expert Review 2 task in the step 2 flow
    Given user switched to "Expert Review 2" view
    And user enters the report set name in the report set name column
    And user clicks on "createReportSetBtnLink" icon
    And user clicks on "approveRepliesRecievedBtn" icon
    And user clicks on "save" icon
    And user clicks on "endTask" icon
    And user clicks on "expertReviewCompletionSelection" icon
    And user clicks on "ProceedBtn" icon
    
    @ILONormes @CreateArticle22ReportSet @Step2HoULastSignOff
    Scenario: User is logged in as Head of Unit task in the step 2 flow for the final sign off
    Given user switched to "Head of Unit" view
    And user enters the report set name in the report set name column
    And user clicks on "createReportSetBtnLink" icon
    And user selects "selectDecisionForCreateDLC" dropdown
    And user clicks on "save" icon 
    And user clicks on "HoUSignOffAfterExpertReviews" icon
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

--Student: Angela Pellillo
--Stundent ID: 21499500
--Module ID: CP6CS19E
--Module Name: Applied Software Engineering

Rule 1: Editor must validate Advert before invoking the SendAdvertCommand
Multiplicity: Many(Advert) to 1(Editor)
Precondition: the Advert must be validated

OCL

context SendAdvertCommand :: execute()
pre: advert.isValidated = true


Rule 2: An Advert must contain AdvertText and AdverGraphics
Multiplicity: Advert must have at least one AdvertGaphis and one AdvertTexts

OCL

context Advert
inv MustContainTextsAndGraphics:
    self.texts->size() > 0 and self.graphics->size() > 0


Rule 3: Each Advert must reference a valid Advertiser
Multiplicity: 1 to 1

OCL

context Advert
inv ValidAdvertiser:
    not self.advertiser.oclIsUndefined()

Rule 4: An Advert can have only one ProcessingCentre, but the ProcessingCentre can have many Adverts
Multiplicity: Many(Advert) to 1(ProcessingCentre)

OCL

context Advert
inv OneProcessingCentre:
    self.processingCentre->size() = 1

Rule 5: The issueNumber in Advert must corresponde to an existing MagazineIssue
Multiplicity: 1 to 1

OCL

context Advert
inv ValidMagazineIssue:
    MagazineIssue.allInstances()->exists(issue | issue.issueNumber = self.issueNumber)


Rule 6: If Advert is not complete, SendAdvertCommand cannot be executed
Precondition: Advert must be complete before executing SendAdvertCommand
Postcondition: ProcessingCentre stores Advert

OCL

contex SendAdvertCommand :: execute()
pre: advert.isComplete = true
post: processingCentre.adverts->includes(advert) --adverts is the list of already stored adverts by the ProcessingCentre

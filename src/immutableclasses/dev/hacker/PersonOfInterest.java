package immutableclasses.dev.hacker;

import immutableclasses.dev.lpa.PersonImmutable;

public class PersonOfInterest extends PersonImmutable {
    public PersonOfInterest(PersonImmutable person) {
        super(person);
    }

}

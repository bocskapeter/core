package eu.bopet.jocadv.ie.step;

public class ApplicationContext extends StepEntity {

    public static ApplicationContext getInstance(int id, String name) {
        ApplicationContext applicationContext = new ApplicationContext();
        applicationContext.setId(id);
        applicationContext.setName(name.stripLeading());
        return applicationContext;
    }

    @Override
    public String toString() {
        return "ApplicationContext{" + super.toString() + '}';
    }
}

package controllers;

public class ControllerFactory {

    public static final Controller getControllerByClass(Class actionClass) {
        try {
            Controller controller = (Controller) actionClass.newInstance();

            return (Controller) actionClass.newInstance();
        } catch (java.lang.InstantiationException | IllegalAccessException | ClassCastException e) {
            e.printStackTrace();    
        }
        return null;
    }

    public static final Controller getControllerByFullClassName(String className) {
        try {
            String name = "controllers.impl." + className + "Controller";
            Class actionClass = Class.forName(name);
            return getControllerByClass(actionClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

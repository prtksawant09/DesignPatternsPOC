package edu.pratik.factory;

public class Shape_Factory {
    public static Shape getShape(String shape) {
        Shape shapeObj = null;
        Class c;
        try {
            c = Class.forName(shape);
            shapeObj = (Shape) c.newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println(shape + " is not a valid class");
        } catch (InstantiationException e) {
            System.out.println(shape + " cannot be instantiated");
        } catch (IllegalAccessException e) {
            System.out.println("Access forbidden to "+shape);
        }
        return shapeObj;
    }
}

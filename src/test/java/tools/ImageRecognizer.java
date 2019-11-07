package tools;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.Iterator;

public class ImageRecognizer {

    private Screen screen;

    private static final Pattern planeImage
            = new Pattern(System.getProperty("user.dir")+"\\src\\test\\resource\\plane.png");
    private static final Pattern busImage
            = new Pattern(System.getProperty("user.dir")+"\\src\\test\\resource\\bus.png");
    private static final Pattern trainImage =
            new Pattern(System.getProperty("user.dir")+"\\src\\test\\resource\\train.png");


    public ImageRecognizer()
    {
        screen = new Screen();
    }

    public int collectImages()
    {
        return collectQuantityPattern(collectImagesByPattern(planeImage)) +
                collectQuantityPattern(collectImagesByPattern(busImage))+
                collectQuantityPattern(collectImagesByPattern(trainImage));
    }

    public Iterator collectImagesByPattern(Pattern patternImage)
    {
        Iterator iterator;
        try
        {
            iterator = screen.findAll(patternImage);
        }
        catch (FindFailed ex)
        {
            System.out.println("Изображения не найдены для паттерна " + patternImage.getFilename());
            return  iterator = null;
        }
        return iterator;
    }

    public int collectQuantityPattern(Iterator iterator)
    {
        int counter = 0;
        if(iterator == null)
        {
            return 0;
        }
        while (iterator.hasNext())
        {

            iterator.next();
            counter++;
        }
        return counter;
    }



}

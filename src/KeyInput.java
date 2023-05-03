import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput extends Frame implements KeyListener {
    private TrickLibrary trickLibrary = new TrickLibrary();
    private PenguinMechanics penguinMechanics = new PenguinMechanics();
    private double startTime = 0;
    private Label l;
    private TextArea area;
    private boolean isRightKeyPressed = false;
    private boolean isLeftKeyPressed = false;
    private boolean isDownKeyPressed = false;
    private boolean isUpKeyPressed = false;
    private boolean isSpaceBarPressed = false;
    public KeyInput() {
        // creating the label
        l = new Label();
// setting the location of the label in frame
        l.setBounds (20, 50, 100, 20);
// creating the text area
        area = new TextArea();
// setting the location of text area
        area.setBounds (20, 80, 300, 300);
// adding the KeyListener to the text area
        area.addKeyListener(this);
// adding the label and text area to the frame
        add(l);
        add(area);
// setting the size, layout and visibility of frame
        setSize (400, 400);
        setLayout (null);
        setVisible (true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                System.out.println("up");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("down");
                // handle down
                break;
            case KeyEvent.VK_LEFT:
                // handle left
                break;
            case KeyEvent.VK_RIGHT :
                // handle right
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            isRightKeyPressed = true;
            System.out.println("right key pressed");
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            isLeftKeyPressed = true;
            System.out.println("left key pressed");
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            isUpKeyPressed = true;
            System.out.println("up key pressed");
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            isDownKeyPressed = true;
            System.out.println("down key pressed");
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            if (!isSpaceBarPressed && System.currentTimeMillis() - startTime > 2000)
            {
                isSpaceBarPressed = true;
                startTime = System.currentTimeMillis();
                System.out.println("space bar pressed");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        detectTricks();

        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            isRightKeyPressed = false;
            //System.out.println("right key released");
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            isLeftKeyPressed = false;
            //System.out.println("left key released");
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            isUpKeyPressed = false;
            //System.out.println("up key released");
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            isDownKeyPressed = false;
            //System.out.println("down key released");
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            //isSpaceBarPressed = false;
            //System.out.println("released");
        }
    }

    public void detectTricks()
    {
        if (isSpaceBarPressed && isRightKeyPressed)
        {
            trickLibrary.rightFlip();
        }
    }
    public void inputTick()
    {
        penguinMechanics.tick();
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Window extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    private Thread thread;
    private boolean running = false;

    private Player player = new Player(100, 100, 64, 64);
    private KeyInput keyInput = new KeyInput(this);
    private LevelHandler levelHandler = new LevelHandler();

    // Runs everytime a new window is created
    public Window(String title)
    {
        JFrame frame = new JFrame(title);

        // sets frame size
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // makes the frame visible and sets frame properties
        frame.setResizable(true);
        frame.setVisible(true);
        frame.add(this);
    }

    // Start the game
    public void start()
    {
        running = true;

        // Create new thread
        thread = new Thread(this);
        thread.start();
    }

    // Stop the game
    public void stop()
    {
        running = false;

        // stop the thread
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // begins when start calls the run method
    // basic run method, dont need to know how it works
    @Override
    public void run()
    {
        // time from last iteration to now
        long lastTime = System.nanoTime();
        // ticks averaged out, trying to attempt?
        double amountofTicks = 60.0;
        // nanoseconds per tick
        double ns = 1000000000 / amountofTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;

        while (running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1)
            {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            // allows for frames per second, using the system timer
            // used for resetting the frames and updates
            if (System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: " + frames + " TICKS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    // updates the window
    public void tick(){
        player.tick();
    }

    // paints onto the window
    public void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null)
        {
            this.createBufferStrategy(2);
            bs = this.getBufferStrategy();
        }
        Graphics graphics = bs.getDrawGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0,0, this.getWidth(), this.getHeight());

        player.render(graphics);

        bs.show();
        graphics.dispose();
    }

    public Player getPlayer()
    {
        return player;
    }
}

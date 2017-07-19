import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MouseListenerDemo extends JFrame implements MouseListener
{
   public static void main( String [] args )
   {
      new MouseListenerDemo( );
   }
   
   public MouseListenerDemo( )
   {
      // configure window
      super( "Mouse Listener Demo" );
      this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      this.getContentPane( ).setBackground( Color.LIGHT_GRAY );
      this.addMouseListener( this );
      this.setSize( 500, 500 );
      this.setVisible( true );
   }
   
   // internal data for mouse position
   private int x, y;         // mouse position
   private String msg = "";  // message
   private Color activeColor = new Color( 255, 255, 204 );

   // Since MouseListener is an interface, you must implement every
   // one of its abstract methods whether you use it or not.
   // If you don't use it, leave it's body an empty { } block.

   public void mouseEntered( MouseEvent e )
   // Called by JVM when mouse moves onto component.
   {
      this.getContentPane( ).setBackground( activeColor );
   }

   public void mouseExited( MouseEvent e )
   // Called by JVM when mouse moves away from component.
   {
      this.getContentPane( ).setBackground( Color.LIGHT_GRAY );
   }
 
   public void mousePressed( MouseEvent e )
   // Called by JVM when user presses and holds mouse button.
   {
      x = e.getX( ); // capture current mouse x-coordinate
      y = e.getY( ); // capture current mouse y-coordinate
      // format display message
      msg = String.format( "Pressed at [%d, %d]", x, y );
      repaint( );   // force call to paint
   }

   public void mouseReleased( MouseEvent e )
   // Called by JVM when user releases mouse button.
   {
      x = e.getX( );
      y = e.getY( );
      msg = String.format( "Released at [%d, %d]", x, y );
      repaint( );
   }

   public void mouseClicked( MouseEvent e )
   // Called by JVM when user clicks mouse button (i.e. presses
   // and releases at the same position).
   {
      x = e.getX( );
      y = e.getY( );
      if ( e.getClickCount( ) == 1 )
         msg = String.format( "Clicked at [%d, %d]", x, y );
      else if ( e.getClickCount( ) == 2 )
         msg = String.format( "Double Clicked at [%d, %d]", x, y );
      repaint( );
   }
      
   public void paint( Graphics g )
   // Inherited from java.awt.Component, this renders the component.
   {
      super.paint( g );
      // set font and color for drawing strings
      g.setColor( Color.black );
      g.setFont( new Font( "Arial", Font.PLAIN, 10 ) );
      g.drawString( msg, x, y ); // draw msg at mouse's position 
   }
}
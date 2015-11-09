package vue;



//Etape 1 :
//Importation des packages Java 2
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;



import java.util.Map;






//Etape 2 :
//Importation des packages Java 3D
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.picking.PickCanvas;
import com.sun.j3d.utils.picking.PickResult;
import com.sun.j3d.utils.picking.behaviors.*;

import controler.TicTacToeControler;

import javax.imageio.ImageIO;
import javax.media.j3d.*;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.vecmath.*;

public class PlateauGUI extends JPanel implements MouseListener {
	TicTacToeControler controler;
	JFrame parent;
	
	private PickCanvas pickCanvas;
	private LinkedList<LinkedList> cylinderList;
	private Map<Sphere,Switch> mapSS;
	private Switch[][][] tabSphere1;
	private Switch[][][] tabSphere2;

public PlateauGUI(JFrame parent, TicTacToeControler controler) {
	this.parent = parent;
	this.controler = controler;
 this.setLayout(new BorderLayout());

 // Etape 3 :
 // Creation du Canvas 3D
 Canvas3D canvas3D =
     new Canvas3D(SimpleUniverse.getPreferredConfiguration());

 canvas3D.addMouseListener(this);

 this.add(canvas3D, BorderLayout.CENTER);

 SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
 simpleU.getViewingPlatform().setNominalViewingTransform();
 BranchGroup scene = createSceneGraph(canvas3D);
 scene.compile();
 simpleU.addBranchGraph(scene);
}

public BranchGroup createSceneGraph(Canvas3D canvas) {
	 BranchGroup parent = new BranchGroup();
	 pickCanvas = new PickCanvas(canvas, parent);
	 pickCanvas.setMode(PickCanvas.BOUNDS);
	
	 // Creation du comportement de rotation une fois l'objet selectionne
	 PickRotateBehavior pickRotate =
	     new PickRotateBehavior(parent,
	                            canvas,
	                            new BoundingSphere());
	 parent.addChild(pickRotate);
	
	 // Creation du comportement de translation une fois l'objet selectionne
	 PickTranslateBehavior pickTranslate =
	     new PickTranslateBehavior(parent,
	                               canvas,
	                               new BoundingSphere());
	 //parent.addChild(pickTranslate);
	
	 // Creation du comportement de zoom une fois l'objet selectionne
	 PickZoomBehavior pickZoom =
	     new PickZoomBehavior(parent,
	                          canvas,
	                          new BoundingSphere());
	 //parent.addChild(pickZoom);
	 
	 
	 // Apparence

	 File g = new File("");
	 String path = g.getAbsolutePath();
	 
	 File fichier_bois1 = new File(path+"/images/bois1.jpg");
	 File fichier_bois2 = new File(path+"/images/bois2.jpg");
	 File fichier_bois3 = new File(path+"/images/bois3.jpg");
	 File fichier_joueur1 = new File(path+"/images/"+controler.getCouleurJoueur1().getNom()+".jpg");
	 File fichier_joueur2 = new File(path+"/images/"+controler.getCouleurJoueur2().getNom()+".jpg");
	 
	 BufferedImage image_bois1 = null;
	 BufferedImage image_bois2 = null;
	 BufferedImage image_bois3 = null;
	 BufferedImage image_joueur1 = null;
	 BufferedImage image_joueur2 = null;
	    try {
	    	image_bois1 = ImageIO.read(fichier_bois1);
	    	image_bois2 = ImageIO.read(fichier_bois2);
	    	image_bois3 = ImageIO.read(fichier_bois3);
	    	image_joueur1 = ImageIO.read(fichier_joueur1);
	    	image_joueur2 = ImageIO.read(fichier_joueur2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	 
	 Appearance appPlateau = new Appearance();
	 Appearance appBaton = new Appearance();
	 Appearance appBoule_j1 = new Appearance();
	 			appBoule_j1.setCapability(Appearance.ALLOW_TEXTURE_WRITE);
	 			appBoule_j1.setCapability(Appearance.ALLOW_TEXTURE_READ);
	 Appearance appBoule_j2 = new Appearance();
		 		appBoule_j2.setCapability(Appearance.ALLOW_TEXTURE_WRITE);
		 		appBoule_j2.setCapability(Appearance.ALLOW_TEXTURE_READ);
	 Appearance appFond = new Appearance();
	
	 Texture texture_bois1 = new TextureLoader(image_bois1).getTexture();
			 texture_bois1.setBoundaryModeS(Texture.WRAP);
			 texture_bois1.setBoundaryModeT(Texture.WRAP);
			 texture_bois1.setBoundaryColor(new Color4f(0.0f, 1.0f, 0.0f, 0.0f));
	 
	 Texture texture_bois2 = new TextureLoader(image_bois2).getTexture();
			 texture_bois2.setBoundaryModeS(Texture.WRAP);
			 texture_bois2.setBoundaryModeT(Texture.WRAP);
			 texture_bois2.setBoundaryColor(new Color4f(0.0f, 1.0f, 0.0f, 0.0f));
			 
	Texture texture_bois3 = new TextureLoader(image_bois3).getTexture();
			texture_bois3.setBoundaryModeS(Texture.WRAP);
			texture_bois3.setBoundaryModeT(Texture.WRAP);
			texture_bois3.setBoundaryColor(new Color4f(0.0f, 1.0f, 0.0f, 0.0f));
			 
	Texture texture_j1 = new TextureLoader(image_joueur1).getTexture();
			texture_j1.setBoundaryModeS(Texture.WRAP);
			texture_j1.setBoundaryModeT(Texture.WRAP);
			texture_j1.setBoundaryColor(new Color4f(0.0f, 1.0f, 0.0f, 0.0f));
			 
	Texture texture_j2 = new TextureLoader(image_joueur2).getTexture();
			texture_j2.setBoundaryModeS(Texture.WRAP);
			texture_j2.setBoundaryModeT(Texture.WRAP);
			texture_j2.setBoundaryColor(new Color4f(0.0f, 1.0f, 0.0f, 0.0f));
	
	TextureAttributes texAttr = new TextureAttributes();
	texAttr.setTextureMode(TextureAttributes.MODULATE);
	
	appPlateau.setTexture(texture_bois1);
	appPlateau.setTextureAttributes(texAttr);
	
	appBaton.setTexture(texture_bois2);
	appBaton.setTextureAttributes(texAttr);
	
	appBoule_j1.setTexture(texture_j1);
	appBoule_j1.setTextureAttributes(texAttr);
	
	appBoule_j2.setTexture(texture_j2);
	appBoule_j2.setTextureAttributes(texAttr);
	
	appFond.setTexture(texture_bois3);
	appFond.setTextureAttributes(texAttr);
	 
	 // Plateau
	TransformGroup generalTG = new TransformGroup();
	generalTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	generalTG.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
	generalTG.setCapability(TransformGroup.ENABLE_PICK_REPORTING);
	
	 TransformGroup plateauTG = new TransformGroup();
	 
	 Float x_box = 0.6f;
	 Float y_box = 0.025f;
	 Float z_box = 0.6f;
	 
	 Transform3D transform = new Transform3D();
	 Vector3f vector = new Vector3f( 0.0f, -0.45f, 0.0f);
	 transform.setTranslation(vector);
	 plateauTG.setTransform(transform);
	 
	 plateauTG.addChild(new Box(x_box, y_box, z_box, Box.GENERATE_TEXTURE_COORDS, appPlateau));
	 

	 
	 cylinderList = new LinkedList<LinkedList>();
	 
	 for(int i=0; i<4; i++){
		 LinkedList<Cylinder> list = new LinkedList<Cylinder>();
		 for(int j=0; j<4; j++){
			 Cylinder baton = new Cylinder(0.05f,1.2f, Cylinder.GENERATE_TEXTURE_COORDS,appBaton);
			 list.add(baton);
		      TransformGroup tg = new TransformGroup();
		      transform = new Transform3D();
		      Float x_cyl = i*0.4f - x_box;
		 	  Float y_cyl = 0.50f;
		 	  Float z_cyl = j*0.4f - z_box;
		      vector = new Vector3f( x_cyl, y_cyl, z_cyl);
		      transform.setTranslation(vector);
		      tg.setTransform(transform);
		      tg.addChild(baton);
		      plateauTG.addChild(tg);
		 }
		 cylinderList.add(list);
	 }
	 
	 
	 
	 TransformGroup sphereTG = new TransformGroup();
	 transform = new Transform3D();
	 vector = new Vector3f( 0.0f, 0.15f, 0.0f);
	 transform.setTranslation(vector);
	 sphereTG.setTransform(transform);
	 
	 mapSS = new HashMap<Sphere, Switch>();
	 tabSphere1 = new Switch[4][4][4];
	 tabSphere2 = new Switch[4][4][4];
	 
	 for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			for (int k = 0; k < 4; k++) {
				
				Sphere sphere = new Sphere(0.14f, Sphere.GENERATE_TEXTURE_COORDS, appBoule_j1);
				Switch visibleSphere = new Switch();
				visibleSphere.addChild(sphere);
				visibleSphere.setCapability(Switch.ALLOW_SWITCH_READ);
				visibleSphere.setCapability(Switch.ALLOW_SWITCH_WRITE);
				visibleSphere.setCapability(Switch.ALLOW_CHILDREN_READ);
				visibleSphere.setCapability(Switch.ALLOW_CHILDREN_WRITE);
				visibleSphere.setWhichChild(Switch.CHILD_NONE);
				//visibleSphere.setWhichChild(Switch.CHILD_ALL);
				tabSphere1[i][j][k]=visibleSphere;
				
				Sphere sphere2 = new Sphere(0.14f, Sphere.GENERATE_TEXTURE_COORDS, appBoule_j2);
				Switch visibleSphere2 = new Switch();
				visibleSphere2.addChild(sphere2);
				visibleSphere2.setCapability(Switch.ALLOW_SWITCH_READ);
				visibleSphere2.setCapability(Switch.ALLOW_SWITCH_WRITE);
				visibleSphere2.setCapability(Switch.ALLOW_CHILDREN_READ);
				visibleSphere2.setCapability(Switch.ALLOW_CHILDREN_WRITE);
				visibleSphere2.setWhichChild(Switch.CHILD_NONE);
				tabSphere2[i][j][k]=visibleSphere2;
				
				//if(i==0 && j==3 && k==0){
				//	System.out.println(sphere);
				//}
				TransformGroup tg = new TransformGroup();
				transform = new Transform3D();
				vector = new Vector3f(i * 0.4f-0.6f, k*0.25f,
						j * 0.4f-0.6f);
				transform.setTranslation(vector);
				tg.setTransform(transform);
				tg.addChild(visibleSphere);
				tg.addChild(visibleSphere2);
				sphereTG.addChild(tg);
			}
		}
	}
		plateauTG.addChild(sphereTG);

	 generalTG.addChild(plateauTG);
	 parent.addChild(generalTG);  
	 
	 // Background
	 TransformGroup tg = new TransformGroup();
	 transform = new Transform3D();
	 vector = new Vector3f(0f, 0f, -20f);
	 transform.setTranslation(vector);
		tg.setTransform(transform);
		tg.addChild(new Box(15f, 15f, 0.1f, Box.GENERATE_TEXTURE_COORDS, appFond));
	 parent.addChild(tg);	
	 
	
	 return parent;
	}

	public void actionPerformed(ActionEvent e ) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		pickCanvas.setShapeLocation(e);
	    PickResult result = pickCanvas.pickClosest();

	    if (result == null) {

	       System.out.println("Nothing picked");

	    } else {

	       Primitive p = (Primitive)result.getNode(PickResult.PRIMITIVE);
	       Shape3D s = (Shape3D)result.getNode(PickResult.SHAPE3D);

	       if (p != null) {
	    	   if(p.getClass().getSimpleName().equals("Cylinder")){
	    		   int x=-1, y=-1;
	    		   int i = 0;
	    		   for(LinkedList<Cylinder> l : cylinderList){
	    			   if(l.indexOf(((Cylinder)p)) != -1){
	    				   x=i;
	    				   y=l.indexOf(((Cylinder)p));
	    			   }
	    			   i++;
	    		   }
	    		   //System.out.println("x: "+x+" y: "+y);

	    		   int z = controler.placementOk(x, y);
	    		   if(z!=-1){
	    			   int idJoueur = controler.getIdJoueur();
	    			   if(idJoueur==1){
	    				   tabSphere1[x][y][z].setWhichChild(Switch.CHILD_ALL);
	    			   } else {
	    				   tabSphere2[x][y][z].setWhichChild(Switch.CHILD_ALL);
	    			   }
	    			   controler.placerPion(x, z, y);
	    			   if(!controler.isAnnonce()){
	    				   int r = controler.partieFinie(x, z, y, idJoueur);
	    				   if(r!=0){
	    					   System.out.println("Gagnant: "+r);
	    					   //JOptionPane.showConfirmDialog(this, "Test");
	    					   String txtPopup =null;
	    					   if(r==1){
	    						   txtPopup=controler.getNomJoueur1()+" a remporté la partie !";
	    					   } else {
	    						   txtPopup=controler.getNomJoueur2()+" a remporté la partie !";
	    					   }
	    					   Popup jd = new Popup(parent,"Victoire",txtPopup,true);
	    					   jd.showPopup();
	    				   }
	    			   }
	    		   }
	    		   //((Sphere)tabSphere[x][y][0].getChild(0)).getAppearance().getName();
	    		   //((Sphere)tabSphere[x][y][0].getChild(0)).setAppearance(null);
	    		   //System.out.println(((Sphere)tabSphere1[x][y][0].getChild(0)));
	    	   }

	    	   if(p.getClass().getSimpleName().equals("Sphere")){
	    		  
	    	   }
	       }
	       /*else if (s != null) {
	    	   System.out.println("s: "+s.getClass().getSimpleName());
	       }*/

	    }
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}
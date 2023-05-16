package uepb.view.controller.abaParte1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class AbaParte1 implements Initializable {
	
	private ToggleButton toggleButtonCarregarCeu;
	private ToggleButton toggleButtonCarregarGrama;
	private ToggleButton toggleButtonCarregarCeuEGrama;

	private Pane paneY;
	private Pane paneU;
	private Pane paneV;

	private ImageView imageViewCarregarCeu;
	private ImageView imageViewCarregarGrama;
	private ImageView imageViewCarregarCeuEGrama;
	
	public AbaParte1(ToggleButton toggleButtonCarregarCeu,
			ToggleButton toggleButtonCarregarGrama,
			ToggleButton toggleButtonCarregarCeuEGrama, Pane paneY, Pane paneU,
			Pane paneV, ImageView imageViewCarregarCeu,
			ImageView imageViewCarregarGrama,
			ImageView imageViewCarregarCeuEGrama) {
		super();
		this.toggleButtonCarregarCeu = toggleButtonCarregarCeu;
		this.toggleButtonCarregarGrama = toggleButtonCarregarGrama;
		this.toggleButtonCarregarCeuEGrama = toggleButtonCarregarCeuEGrama;
		this.paneY = paneY;
		this.paneU = paneU;
		this.paneV = paneV;
		this.imageViewCarregarCeu = imageViewCarregarCeu;
		this.imageViewCarregarGrama = imageViewCarregarGrama;
		this.imageViewCarregarCeuEGrama = imageViewCarregarCeuEGrama;
	}

	public void initialize(URL location, ResourceBundle resources) {

		toggleButtonCarregarGrama.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				toggleButtonCarregarGrama.setSelected(true);
				toggleButtonCarregarCeu.setSelected(false);
				toggleButtonCarregarCeuEGrama.setSelected(false);

				Image y = new Image("/uepb/icones/gramaY.jpg");
				Image u = new Image("/uepb/icones/gramaU.jpg");
				Image v = new Image("/uepb/icones/gramaV.jpg");

				ImageView Iy = new ImageView();
				ImageView Iu = new ImageView();
				ImageView Iv = new ImageView();

				Iy.setImage(y);
				Iu.setImage(u);
				Iv.setImage(v);

				Iy.setFitHeight(220);
				Iy.setFitWidth(220);

				Iu.setFitHeight(110);
				Iu.setFitWidth(110);

				Iv.setFitHeight(110);
				Iv.setFitWidth(110);
				
				//Iv.setOnZoom(null);

				paneY.getChildren().add(Iy);
				paneU.getChildren().add(Iu);
				paneV.getChildren().add(Iv);
			}
		});

		toggleButtonCarregarCeu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				toggleButtonCarregarGrama.setSelected(false);
				toggleButtonCarregarCeu.setSelected(true);
				toggleButtonCarregarCeuEGrama.setSelected(false);

				Image y = new Image("/uepb/icones/ceuY.jpg");
				Image u = new Image("/uepb/icones/ceuU.jpg");
				Image v = new Image("/uepb/icones/ceuV.jpg");

				ImageView Iy = new ImageView();
				ImageView Iu = new ImageView();
				ImageView Iv = new ImageView();

				Iy.setImage(y);
				Iu.setImage(u);
				Iv.setImage(v);

				Iy.setFitHeight(220);
				Iy.setFitWidth(220);

				Iu.setFitHeight(110);
				Iu.setFitWidth(110);

				Iv.setFitHeight(110);
				Iv.setFitWidth(110);

				paneY.getChildren().add(Iy);
				paneU.getChildren().add(Iu);
				paneV.getChildren().add(Iv);
			}
		});
		
		toggleButtonCarregarCeuEGrama.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				toggleButtonCarregarGrama.setSelected(false);
				toggleButtonCarregarCeu.setSelected(false);
				toggleButtonCarregarCeuEGrama.setSelected(true);

				Image y = new Image("/uepb/icones/ceuGramaY.jpg");
				Image u = new Image("/uepb/icones/ceuGramaU.jpg");
				Image v = new Image("/uepb/icones/ceuGramaV.jpg");

				ImageView Iy = new ImageView();
				ImageView Iu = new ImageView();
				ImageView Iv = new ImageView();

				Iy.setImage(y);
				Iu.setImage(u);
				Iv.setImage(v);

				Iy.setFitHeight(220);
				Iy.setFitWidth(220);

				Iu.setFitHeight(110);
				Iu.setFitWidth(110);

				Iv.setFitHeight(110);
				Iv.setFitWidth(110);

				paneY.getChildren().add(Iy);
				paneU.getChildren().add(Iu);
				paneV.getChildren().add(Iv);
			}
		});

		Image imagemCarregarGrama = new Image("/uepb/icones/grama.png");
		imageViewCarregarGrama.setImage(imagemCarregarGrama);

		Image imagemCarregarCeu = new Image("/uepb/icones/ceu.png");
		imageViewCarregarCeu.setImage(imagemCarregarCeu);

		Image imagemCarregarCeuEGrama = new Image("/uepb/icones/ceuGrama.png");
		imageViewCarregarCeuEGrama.setImage(imagemCarregarCeuEGrama);

		toggleButtonCarregarCeu.setGraphic(imageViewCarregarCeu);
		toggleButtonCarregarGrama.setGraphic(imageViewCarregarGrama);
		toggleButtonCarregarCeuEGrama.setGraphic(imageViewCarregarCeuEGrama);

		
	}

}

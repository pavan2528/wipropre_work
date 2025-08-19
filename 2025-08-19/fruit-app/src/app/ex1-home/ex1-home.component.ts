import { Component } from '@angular/core';
import { Ex1DisplayListComponent } from '../ex1-display-list/ex1-display-list.component';
import { Ex5fruitComponent } from '../ex5fruit/ex5fruit.component';
import { IFruit } from '../ifruit';

@Component({
  selector: 'app-ex1-home',
  imports: [Ex5fruitComponent],
  templateUrl: './ex1-home.component.html',
  styleUrl: './ex1-home.component.css'
})
export class Ex1HomeComponent {
fruits:  IFruit[] = [
    { 
      name: 'Apple', 
      image: 'https://upload.wikimedia.org/wikipedia/commons/1/15/Red_Apple.jpg', 
      description: 'Red and juicy apple full of vitamins.' 
    },
    { 
      name: 'Banana', 
      image: 'https://upload.wikimedia.org/wikipedia/commons/8/8a/Banana-Single.jpg', 
      description: 'Sweet and soft banana, rich in potassium.' 
    },
    { 
      name: 'Mango', 
      image: 'https://upload.wikimedia.org/wikipedia/commons/9/90/Hapus_Mango.jpg', 
      description: 'Delicious mango, the king of fruits.' 
    },
    { 
      name: 'Orange', 
      image: 'https://upload.wikimedia.org/wikipedia/commons/c/c4/Orange-Fruit-Pieces.jpg', 
      description: 'Fresh orange full of vitamin C.' 
    },
    { 
      name: 'Pineapple', 
      image: 'https://upload.wikimedia.org/wikipedia/commons/c/cb/Pineapple_and_cross_section.jpg', 
      description: 'Tropical pineapple with tangy flavor.' 
    },
    { 
      name: 'Strawberry', 
      image: 'https://upload.wikimedia.org/wikipedia/commons/2/29/PerfectStrawberry.jpg', 
      description: 'Sweet and juicy strawberries.' 
    },
    
    { 
      name: 'Kiwi', 
      image: 'https://upload.wikimedia.org/wikipedia/commons/d/d3/Kiwi_aka.jpg', 
      description: 'Tangy kiwi fruit with vitamin C.' 
    }
];

 removeFruit(fruitName: string) {
    this.fruits = this.fruits.filter(fruit => fruit.name !== fruitName);
  }

}

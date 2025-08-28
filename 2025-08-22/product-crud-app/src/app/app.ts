import { Component, signal } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterModule],
  template: `
    <nav style="margin-bottom:12px;">
      <a routerLink="/products">Products</a> |
      <a routerLink="/products/add">Add Product</a>
    </nav>
    <router-outlet></router-outlet>
  `
})
export class App {
  protected readonly title = signal('product-crud-app');
}

import { RouterModule, Routes } from '@angular/router';
import { ProductList } from './products/product-list/product-list';
import { ProductForm } from './products/product-form/product-form';
import { NgModule } from '@angular/core';
import { OrderHistory } from './order-history/order-history';
import { placeorder } from './place-order/place-order';

export const routes: Routes = [
  { path: '', redirectTo: 'products', pathMatch: 'full' },
  { path: 'place-order', component: placeorder },
  { path: 'order-history', component: OrderHistory },
  { path: 'products', component: ProductList },
  { path: 'products/add', component: ProductForm },
  { path: 'products/edit/:id', component: ProductForm },
  { path: '**', redirectTo: 'products' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

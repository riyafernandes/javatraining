import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AcceptRejectComponent } from './accept-reject/accept-reject.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { AddMenuComponent } from './add-menu/add-menu.component';
import { AddVendorComponent } from './add-vendor/add-vendor.component';

import { CustomerDashBoardComponent } from './customer-dash-board/customer-dash-board.component';
import { CustomerInfoComponent } from './customer-info/customer-info.component';
import { CustomerLoginComponent } from './customer-login/customer-login.component';
import { CustomerOneWalletComponent } from './customer-one-wallet/customer-one-wallet.component';
import { CustomerOrdersComponent } from './customer-orders/customer-orders.component';
import { CustomerPendingOrdersComponent } from './customer-pending-orders/customer-pending-orders.component';
import { CustomerSearchComponent } from './customer-search/customer-search.component';
import { CustomerWalletsComponent } from './customer-wallets/customer-wallets.component';
import { CustomerComponent } from './customer/customer.component';
import { MenuComponent } from './menu/menu.component';
import { PlaceOrderComponent } from './place-order/place-order.component';
import { ShowMenuComponent } from './show-menu/show-menu.component';
import { VendorDashBoardComponent } from './vendor-dash-board/vendor-dash-board.component';
import { VendorInfoComponent } from './vendor-info/vendor-info.component';
import { VendorLoginComponent } from './vendor-login/vendor-login.component';
import { VendorOrdersComponent } from './vendor-orders/vendor-orders.component';
import { VendorPendingOrdersComponent } from './vendor-pending-orders/vendor-pending-orders.component';
import { VendorSearchComponent } from './vendor-search/vendor-search.component';
import { VendorComponent } from './vendor/vendor.component';

const routes: Routes = [
  {path:'' ,component:MenuComponent},
  {path:'HomePage' ,component:MenuComponent},

  {path: 'CustomerDashboard',component:CustomerDashBoardComponent},
  {path: 'CustomerDashboard',component:CustomerDashBoardComponent,children : [
    {path: 'Customer',component:CustomerComponent,outlet : "Rllproject"},
    {path: 'CustomerSearch',component:CustomerSearchComponent,outlet : "Rllproject"},
    {path: 'CustomerInfo',component:CustomerInfoComponent,outlet : "Rllproject"},
    {path: 'CustomerOrders',component:CustomerOrdersComponent,outlet : "Rllproject"},
    {path: 'CustomerPendingOrders',component:CustomerPendingOrdersComponent,outlet : "Rllproject"},
    {path: 'CustomerWallets',component:CustomerWalletsComponent,outlet : "Rllproject"},
    {path: 'CustomerOneWallets',component:CustomerOneWalletComponent,outlet : "Rllproject"},
    {path: 'PlaceOrder',component:PlaceOrderComponent,outlet : "Rllproject"},
    {path: 'AddCustomer',component:AddCustomerComponent,outlet : "Rllproject"},
    {path: 'ShowMenu',component:ShowMenuComponent,outlet : "Rllproject"},
    
  ]},


  {path: 'VendorDashboard',component:VendorDashBoardComponent},
  {path: 'VendorDashboard',component:VendorDashBoardComponent,children : [
    {path: 'Vendor',component:VendorComponent,outlet : "Rllproject"},
    {path: 'VendorSearch',component:VendorSearchComponent,outlet : "Rllproject"},
    {path: 'VendorInfo',component:VendorInfoComponent,outlet : "Rllproject"},
    {path: 'VendorOrders',component:VendorOrdersComponent,outlet : "Rllproject"},
    {path: 'VendorPendingOrders',component:VendorPendingOrdersComponent,outlet : "Rllproject"},
    {path: 'AddVendor',component:AddVendorComponent,outlet : "Rllproject"},
    {path: 'AddMenu',component:AddMenuComponent,outlet : "Rllproject"},
    {path: 'ShowMenu',component:ShowMenuComponent,outlet : "Rllproject"},
    {path: 'acceptreject',component:AcceptRejectComponent,outlet : "Rllproject"},
  ]},
  {path:'AddCustomer',component:AddCustomerComponent},
  {path:'CustomerLogin',component:CustomerLoginComponent},
  {path: 'AddVendor',component:AddVendorComponent},


  {path:'VendorLogin',component:VendorLoginComponent}

  ]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

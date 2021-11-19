import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VendorComponent } from './vendor/vendor.component';
import { VendorDashBoardComponent } from './vendor-dash-board/vendor-dash-board.component';
import { VendorInfoComponent } from './vendor-info/vendor-info.component';
import { VendorLoginComponent } from './vendor-login/vendor-login.component';
import { VendorSearchComponent } from './vendor-search/vendor-search.component';
import { VendorOrdersComponent } from './vendor-orders/vendor-orders.component';
import { VendorPendingOrdersComponent } from './vendor-pending-orders/vendor-pending-orders.component';
import { CustomerComponent } from './customer/customer.component';
import { CustomerDashBoardComponent } from './customer-dash-board/customer-dash-board.component';
import { CustomerInfoComponent } from './customer-info/customer-info.component';
import { CustomerLoginComponent } from './customer-login/customer-login.component';
import { CustomerOrdersComponent } from './customer-orders/customer-orders.component';
import { CustomerPendingOrdersComponent } from './customer-pending-orders/customer-pending-orders.component';
import { CustomerSearchComponent } from './customer-search/customer-search.component';
import { MenuComponent } from './menu/menu.component';
import { CustomerOneWalletComponent } from './customer-one-wallet/customer-one-wallet.component';
import { CustomerWalletsComponent } from './customer-wallets/customer-wallets.component';
import { PlaceOrderComponent } from './place-order/place-order.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { AddVendorComponent } from './add-vendor/add-vendor.component';
import { AddMenuComponent } from './add-menu/add-menu.component';
import { ShowMenuComponent } from './show-menu/show-menu.component';
import { AcceptRejectComponent } from './accept-reject/accept-reject.component';
import { AddWalletComponent } from './add-wallet/add-wallet.component';

@NgModule({
  declarations: [
    AppComponent,
    VendorComponent,
    VendorDashBoardComponent,
    VendorInfoComponent,
    VendorLoginComponent,
    VendorSearchComponent,
    VendorOrdersComponent,
    VendorPendingOrdersComponent,
    CustomerComponent,
    CustomerDashBoardComponent,
    CustomerInfoComponent,
    CustomerLoginComponent,
    CustomerOrdersComponent,
    CustomerPendingOrdersComponent,
    CustomerSearchComponent,
    MenuComponent,
    CustomerOneWalletComponent,
    CustomerWalletsComponent,
    PlaceOrderComponent,
    AddCustomerComponent,
    AddVendorComponent,
    AddMenuComponent,
    ShowMenuComponent,
    AcceptRejectComponent,
    AddWalletComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

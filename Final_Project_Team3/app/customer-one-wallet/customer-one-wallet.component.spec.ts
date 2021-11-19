import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerOneWalletComponent } from './customer-one-wallet.component';

describe('CustomerOneWalletComponent', () => {
  let component: CustomerOneWalletComponent;
  let fixture: ComponentFixture<CustomerOneWalletComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerOneWalletComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerOneWalletComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

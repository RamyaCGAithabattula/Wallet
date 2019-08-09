import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AddAccountComponent } from './AddFeature/addAccount.component';
import { DepositComponent } from './DepositFeature/deposit.component';
import { WithdrawComponent } from './WthdrawFeature/withdraw.component';
import { TransferComponent } from './TransferFeature/transfer.component';
import { ShowComponent } from './ShowAccountsWithActions/show.component';

const routes: Routes=[
   
    {path:'home',component:ShowComponent},
    {path:'add',component:AddAccountComponent},
    {path:'deposit',component:DepositComponent},
    {path:'withdraw',component:WithdrawComponent},
    {path:'transfer',component:TransferComponent},
    {path:'**',redirectTo:'home', pathMatch:'full'},
  
]


@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        RouterModule.forRoot(routes),
        HttpClientModule
    ],
    declarations: [
        AppComponent,
        AddAccountComponent,
        DepositComponent,
        WithdrawComponent,
        TransferComponent,
        ShowComponent
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { 

}
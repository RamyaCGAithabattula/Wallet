import { Component } from "@angular/core";
import { AccountService } from "../services/accounts.service";
import { Account } from "../Models/Account";


@Component({
    selector: 'add-account',
    templateUrl: 'addComponent.html'
})
export class AddAccountComponent{

    isError = false
    added = false
    
    model:Account={
        id:0,
        phone:'',
        accountHolder:'',
        balance:0
    }
    account:Account
    err:Error

    constructor(private service : AccountService){

    }

    refresh(){
        window.location.reload()
    }

    onSubmit(){
        //this.account = new Account(this.id,this.phone,this.accountHolder,this.balance)
        this.service.add(this.model).subscribe(
            res=>{
                //console.log(res)
                this.account = res
                this.added = true
            },
            err=>{
                //alert("An error has occurred")
                this.err = err
                this.isError = true
            }
        )
    }
}
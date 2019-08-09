import { Component } from "@angular/core";
import { DepositAndWithdrawFormat } from "../Models/draw.deposit";
import { AccountService } from "../services/accounts.service";

@Component({
    selector:'app-deposit',
    templateUrl:'deposit.component.html'
})
export class DepositComponent{
    isNegative = false
    isError = false
    deposited = false

    model:DepositAndWithdrawFormat={
        id:0,
        amount:0
    }

    constructor(private service: AccountService){

    }

    refresh(){
        window.location.reload()
    }

    deposit(){
        this.service.deposit(this.model).subscribe(
            res=>{
                console.log(res)

                if(this.model.amount > 0)
                    this.deposited = true
                else
                    this.isNegative = true
            },
            err=>{
                //alert("An error has occurred")
                this.isError = true
            }
        )
        
    }
}
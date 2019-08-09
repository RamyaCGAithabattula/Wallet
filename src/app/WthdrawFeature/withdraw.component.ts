import { Component } from "@angular/core";
import { DepositAndWithdrawFormat } from "../Models/draw.deposit";
import { AccountService } from "../services/accounts.service";

@Component({
    selector:'app-withdraw',
    templateUrl:'withdraw.component.html'
})
export class WithdrawComponent{

    isError = false
    isNegative = false
    withdrawn = false

    model:DepositAndWithdrawFormat={
        id:0,
        amount:0
    }
    err:Error

    constructor(private service: AccountService){

    }

    refresh(){
        window.location.reload()
    }

    withdraw(){
        this.service.withdraw(this.model).subscribe(
            res=>{
                console.log(res)
                if(this.model.amount > 0)
                    this.withdrawn = true
                else
                    this.isNegative = true
            },
            err=>{
                //alert("An error has occurred")
                this.err=err
                console.log(err)
                this.isError = true
            }
        )
    }

}
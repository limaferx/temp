import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EOF {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int count = 1;
        while(sc.hasNextLine()){
            System.out.println(count + " " + sc.nextLine());
            count++;
        }
    }
}
/*
run:
Lorem ipsum dolor sit amet, dolore praesent facilisis vis ea. Purto graeco eleifend pri eu, id ceteros gloriatur est. Per ei consul epicurei deseruisse. Natum consequuntur usu an, his ut labitur menandri, pri in labore nusquam. No vel molestie appareat, ne sit choro partiendo efficiantur. Quodsi adipiscing eam ei.

Nec congue equidem ut, perpetua incorrupte liberavisse sit eu. Ut usu accusamus mediocritatem conclusionemque. Persius voluptatum sed ex, sea magna populo eirmod id, vidit complectitur ad qui. Cu elit instructior vel. Qui et integre blandit expetenda, id quas melius comprehensam eam.

Eu nec ferri euripidis necessitatibus. Nisl mutat persecuti sit et. Debet verterem mea et, cum sint magna in, ne affert utinam saperet pri. Mei in hinc tollit tractatos, qui et nobis oblique offendit. Periculis omittantur ne eos, eu primis imperdiet per. Eos ne velit aperiri vituperatoribus, ut nec possit ancillae. Alia maiorum mel at, has porro iracundia ea, id causae ancillae inciderint mel.

Iudico dolorem mei an, ut his modus adipisci comprehensam, in erant tantas dicunt eos. Mei eu scaevola deseruisse, has quaestio periculis in. Possit causae vix no. Oratio sadipscing nec in, vim illum philosophia ut. An vis pericula hendrerit, consul philosophia cu eam, sit ex illud omittantur.

Fierent omittam moderatius te pri. Te errem quaeque vis, ius veri adipiscing no. In pro iudico possim quaeque, at brute aliquid splendide nam. Pro velit legimus molestie ad, tantas eloquentiam ei has, admodum torquatos id sea. In sumo ipsum quo, pri ex iudico integre, in qui quodsi nostrum.
1 Lorem ipsum dolor sit amet, dolore praesent facilisis vis ea. Purto graeco eleifend pri eu, id ceteros gloriatur est. Per ei consul epicurei deseruisse. Natum consequuntur usu an, his ut labitur menandri, pri in labore nusquam. No vel molestie appareat, ne sit choro partiendo efficiantur. Quodsi adipiscing eam ei.
2 
3 Nec congue equidem ut, perpetua incorrupte liberavisse sit eu. Ut usu accusamus mediocritatem conclusionemque. Persius voluptatum sed ex, sea magna populo eirmod id, vidit complectitur ad qui. Cu elit instructior vel. Qui et integre blandit expetenda, id quas melius comprehensam eam.
4 
5 Eu nec ferri euripidis necessitatibus. Nisl mutat persecuti sit et. Debet verterem mea et, cum sint magna in, ne affert utinam saperet pri. Mei in hinc tollit tractatos, qui et nobis oblique offendit. Periculis omittantur ne eos, eu primis imperdiet per. Eos ne velit aperiri vituperatoribus, ut nec possit ancillae. Alia maiorum mel at, has porro iracundia ea, id causae ancillae inciderint mel.
6 
7 Iudico dolorem mei an, ut his modus adipisci comprehensam, in erant tantas dicunt eos. Mei eu scaevola deseruisse, has quaestio periculis in. Possit causae vix no. Oratio sadipscing nec in, vim illum philosophia ut. An vis pericula hendrerit, consul philosophia cu eam, sit ex illud omittantur.
8 
9 Fierent omittam moderatius te pri. Te errem quaeque vis, ius veri adipiscing no. In pro iudico possim quaeque, at brute aliquid splendide nam. Pro velit legimus molestie ad, tantas eloquentiam ei has, admodum torquatos id sea. In sumo ipsum quo, pri ex iudico integre, in qui quodsi nostrum.

*/
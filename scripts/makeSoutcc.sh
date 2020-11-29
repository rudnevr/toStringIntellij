cat <<EOF > out
groovyScript("
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
EOF

cat ../src/main/groovy/PsiParameter_.groovy >> out
cat ../src/main/groovy/CallGenerator.groovy >> out
cat ./RemapPSI.groovy >> out

cat out

echo '", methodParameters())
' >> out

package co.com.s.mongo.repository.unitmeasure;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.com.s.mongo.collection.unitmeasure.LogisticaDocument;

/**
 * MongoDBUnitMeasureRepository
 * @autor
 * Extiende de MongoRepository
 */
public interface ILogisticaRepository extends MongoRepository<LogisticaDocument, String> {
}
